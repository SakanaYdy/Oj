<template>
  <div id="userLogin">
    <a-form
      :model="form"
      :style="{ maxWidth: '560px', margin: '0 auto' }"
      @submit="handleSubmit"
    >
      <h2>用户登录</h2>
      <a-form-item field="userAccount" label="账户">
        <a-input v-model="form.userAccount" placeholder="请输入账户" />
      </a-form-item>
      <a-form-item field="userPassword" label="密码">
        <a-input-password
          v-model="form.userPassword"
          placeholder="请输入密码"
        />
      </a-form-item>
      <a-form-item>
        <a-button type="primary" html-type="submit">提交</a-button>
      </a-form-item>
    </a-form>
  </div>
</template>

<script setup lang="ts">
import { reactive } from "vue";
import { UserControllerService, UserLoginRequest } from "../../../generated";
import { useRouter } from "vue-router";
import { useStore } from "vuex";

const form = reactive({
  userAccount: "",
  userPassword: "",
} as UserLoginRequest);

const router = useRouter();
const store = useStore();

const handleSubmit = async () => {
  const res = await UserControllerService.userLoginUsingPost(form);
  // 登录成功之后跳转回主页
  if (res.code === 0) {
    await store.dispatch("user/getLoginUser");
    router.push({
      path: "/",
      replace: true,
    });
    // alert("登录成功" + JSON.stringify(res.data));
  } else {
    alert("登录失败" + res.message);
  }
};
</script>

<style scoped>
/* #userLogin {
  background-image: url('../../assets/1.png');
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  min-height: 100vh; /* 设置背景图片撑满整个视口 
  display: flex;
  justify-content: center;
  align-items: center;
} */
</style>
