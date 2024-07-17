<template>
  <div id="app">
    <template v-if="route.fullPath.startsWith('/user')">
      <router-view />
    </template>
    <template v-else>
      <BasicLayout />
    </template>
  </div>
</template>

<script setup lang="ts">
import BasicLayout from "./layouts/BasicLayout.vue";

import { onMounted } from "vue";
import { useRoute } from "vue-router";

const route = useRoute();

/**
 * 全局初始化函数
 */
const doInit = () => {
  console.log("欢迎来到YDY的OJ网站");
};

onMounted(() => {
  doInit();
});
</script>

<style>
#app {
}
</style>
