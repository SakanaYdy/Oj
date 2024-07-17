import router from "@/router";
import store from "@/store";
import ACCESS_ENUM from "./accessEnum";
import checkAccess from "./checkAccess";

router.beforeEach(async (to, from, next) => {
  console.log("全局路由");
  let loginUser = store.state.user.loginUser;

  // 如果用户没有登录，尝试获取登录用户信息
  if (!loginUser || !loginUser.userRole) {
    await store.dispatch("user/getLoginUser");
    loginUser = store.state.user.loginUser; // 更新 loginUser
  }

  // 权限校验
  const needAccess = (to.meta?.access as string) ?? ACCESS_ENUM.NOT_LOGIN;
  if (needAccess !== ACCESS_ENUM.NOT_LOGIN) {
    // 如果用户没有登录或者没有权限，跳转到登录页面
    if (
      !loginUser ||
      !loginUser.userRole ||
      loginUser.userRole === ACCESS_ENUM.NOT_LOGIN
    ) {
      next(`/user/login?redirect=${to.fullPath}`); // 登录之后重定向到原来的目录
      return;
    }
  }

  // 检查用户是否有权限访问该路由
  if (!checkAccess(loginUser, needAccess)) {
    next("/noAuth");
    return;
  }
  next();
});
