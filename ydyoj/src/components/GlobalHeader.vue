<template>
  <a-row
    class="grid-demo"
    style="margin-bottom: 16px"
    align="center"
    :wrap="false"
  >
    <a-col flex="auto">
      <div class="globalHeader">
        <a-menu
          mode="horizontal"
          :default-selected-keys="selectedKeys"
          @menu-item-click="doMeauClick"
        >
          <a-menu-item
            key="0"
            :style="{ padding: 0, marginRight: '38px' }"
            disabled
          >
            <div class="title-bar">
              <img class="logo" src="../assets/oj-logo.png" />
              <div class="title">YDY-OJ</div>
            </div>
          </a-menu-item>
          <a-menu-item v-for="item in visibleRoutes" :key="item.path">
            {{ item.name }}
          </a-menu-item>
        </a-menu>
      </div>
    </a-col>
    <a-col flex="100px">
      <div>{{ store.state.user.loginUser.userName }}</div>
    </a-col>
  </a-row>
</template>

<script setup lang="ts">
import { computed, ref } from "vue";
import { useRouter } from "vue-router";
import { useStore } from "vuex";
import { routes } from "../router/routes";
import checkAccess from "../access/checkAccess";
import ACCESS_ENUM from "@/access/accessEnum";

const router = useRouter();
const selectedKeys = ref(["/"]);
const store = useStore();

// 注意这里不能使用变量记录loginUser ，因为需要更新
const visibleRoutes = computed(() => {
  return routes.filter((item, index) => {
    if (item.meta?.hideInMeau) {
      return false;
    }
    // 权限校验
    if (!checkAccess(store.state.user.loginUser, item.meta?.access as string))
      return false;
    return true;
  });
});

router.afterEach((to, from, failure) => {
  selectedKeys.value = [to.path];
});

const doMeauClick = (key: string) => {
  router.push({
    path: key,
  });
};

// // 三秒之后自动登录
// setTimeout(() => {
//   store.dispatch("user/getLoginUser", {
//     userName: "杨大宇",
//     userRole: ACCESS_ENUM.ADMIN,
//   });
// }, 3000);
</script>

<style scoped>
.title-bar {
  display: flex;
  align-items: center;
}
.logo {
  height: 64px;
}
.title {
  color: #444;
  margin-left: 16px;
}
</style>
