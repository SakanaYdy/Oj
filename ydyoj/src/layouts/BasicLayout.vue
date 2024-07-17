<template>
  <div id="basicLayout">
    <a-layout style="min-height: 100vh">
      <a-layout-header class="header">
        <GlobalHeader />
      </a-layout-header>
      <a-layout-content class="content">
        <router-view />
      </a-layout-content>
      <a-layout-footer class="footer"> YDY 的 OJ 网站 </a-layout-footer>
    </a-layout>
  </div>
</template>

<script setup lang="ts">
import GlobalHeader from "../components/GlobalHeader.vue";
</script>

<style scoped>
.header {
  margin-bottom: 16px;
}

.content {
  /* background: linear-gradient(to right, #bbb, #fff); */
  margin-bottom: 16px;
  padding: 20px;
}
.footer {
  background: #efefefef;
  padding: 16px;
  position: sticky;
  bottom: 0;
  left: 0;
  right: 0;
  text-align: center;
}
</style>
