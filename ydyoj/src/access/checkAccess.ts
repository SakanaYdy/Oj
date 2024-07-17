import ACCESS_ENUM from "./accessEnum";

/**
 * 权限检查
 * @param loginUser  登录用户
 * @param needAccess   所需要的权限
 */
const checkAccess = (loginUser: any, needAccess = ACCESS_ENUM.NOT_LOGIN) => {
  // 如果没有user，则显示未登录
  const loginUserAccess = loginUser?.userRole ?? ACCESS_ENUM.NOT_LOGIN;

  // 什么权限都不需要
  if (needAccess === ACCESS_ENUM.NOT_LOGIN) return true;
  // 需要登录权限
  if (needAccess === ACCESS_ENUM.USER) {
    if (loginUserAccess === ACCESS_ENUM.NOT_LOGIN) return false;
  }
  if (needAccess === ACCESS_ENUM.ADMIN)
    if (loginUserAccess !== ACCESS_ENUM.ADMIN) return false;
  return true;
};

export default checkAccess;
