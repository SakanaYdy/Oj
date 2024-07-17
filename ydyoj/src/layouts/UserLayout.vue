<template>
  <div id="userLayout">
    <a-layout style="min-height: 100vh">
      <a-layout-header class="header">
        <a-space align="center">
          <img src="../assets/oj-logo.png" class="logo" />
          <div>YDY-OJ</div>
        </a-space>
      </a-layout-header>
      <a-layout-content class="content">
        <div align="center">
          <router-view />
        </div>
      </a-layout-content>
      <a-layout-footer class="footer"> YDY 的 OJ 网站 </a-layout-footer>
    </a-layout>
  </div>
</template>

<script setup lang="ts"></script>

<style scoped>
#userLayout {
  text-align: center;
  /* background: url("../assets/back.jpeg") 0% 0% / 100% 100%; */
}
.header {
  margin-bottom: 16px;
}
.logo {
  width: 120px;
  margin-top: 16px;
}

.content {
  margin-bottom: 16px;
  padding: 20px;
}
.footer {
  padding: 16px;
  position: sticky;
  bottom: 0;
  left: 0;
  right: 0;
  text-align: center;
}
</style>
