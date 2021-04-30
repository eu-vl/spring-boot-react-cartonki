<template>
  <div class="auth-layout">
    <router-view name="Registration" />
    <router-view name="Login" />
  </div>
</template>

<script>
export default {
  name: "AuthLayout",
};
</script>

<style>
</style>