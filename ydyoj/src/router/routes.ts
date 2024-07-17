import { RouteRecordRaw } from "vue-router";
import ExampleView from "../views/ExampleView.vue";
import AdminView from "../views/AdminView.vue";
import NoAuthView from "../views/NoAuthView.vue";
import ACCESS_ENUM from "@/access/accessEnum";
import UserLayout from "../layouts/UserLayout.vue";
import UserLogin from "../views/user/UserLogin.vue";
import UserRegister from "../views/user/UserRegister.vue";
import AddQuestionView from "../views/question/AddQuestionView.vue";
import ManageQuestionView from "../views/question/ManageQuestionView.vue";
import QuestionsView from "../views/question/QuestionsView.vue";
import ViewQuestionView from "../views/question/ViewQuestionView.vue";
import QuestionSubmitView from "../views/question/QuestionSubmitView.vue";

export const routes: Array<RouteRecordRaw> = [
  {
    path: "/user",
    name: "用户页面",
    component: UserLayout,
    children: [
      {
        path: "/user/login",
        name: "登录页面",
        component: UserLogin,
      },
      {
        path: "/user/register",
        name: "注册页面",
        component: UserRegister,
      },
    ],
    meta: {
      hideInMeau: true,
    },
  },
  {
    path: "/add/question",
    name: "创建题目",
    component: AddQuestionView,
  },
  {
    path: "/update/question",
    name: "更新题目",
    component: AddQuestionView,
    meta: {
      // access: ACCESS_ENUM.ADMIN,
      hideInMeau: true,
    },
  },
  {
    path: "/manage/question/",
    name: "管理题目",
    component: ManageQuestionView,
    // meta: {
    //   access: ACCESS_ENUM.ADMIN,
    // },
  },
  {
    path: "/",
    name: "主页",
    component: QuestionsView,
  },
  {
    path: "/questions",
    name: "浏览题目",
    component: QuestionsView,
  },
  {
    path: "/question_submit",
    name: "浏览题目提交",
    component: QuestionSubmitView,
  },
  {
    path: "/view/question/:id",
    name: "在线做题",
    component: ViewQuestionView,
    props: true,
    meta: {
      access: ACCESS_ENUM.USER,
      hideInMeau: true,
    },
  },
  // {
  //   path: "/hidden",
  //   name: "隐藏页面",
  //   component: ExampleView,
  //   meta: {
  //     hideInMeau: true,
  //   },
  // },
  // {
  //   path: "/admin",
  //   name: "管理员页面",
  //   component: AdminView,
  //   meta: {
  //     access: ACCESS_ENUM.ADMIN,
  //   },
  // },
  {
    path: "/noAuth",
    name: "无权限页面",
    component: NoAuthView,
    meta: {
      hideInMeau: true,
    },
  },
  // {
  //   path: "/about",
  //   name: "我的",
  //   // route level code-splitting
  //   // this generates a separate chunk (about.[hash].js) for this route
  //   // which is lazy-loaded when the route is visited.
  //   component: () =>
  //     import(/* webpackChunkName: "about" */ "../views/AboutView.vue"),
  // },
];
