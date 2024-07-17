<template>
  <div id="exampleView">
    <MdEditor :value="mdValue" :handle-change="onMdChange" />
    <CodeEditor :value="codeValue" :handle-change="onCodeChange" />
  </div>
</template>

<script setup lang="ts">
import CodeEditor from "@/components/CodeEditor.vue";
import MdEditor from "@/components/MdEditor.vue";
import { ref } from "vue";

const mdValue = ref("");
const onMdChange = (v: string) => {
  mdValue.value = v;
};

const codeValue = ref("");
const onCodeChange = (v: string) => {
  codeValue.value = v;
  console.log(codeValue.value);
};
</script>
