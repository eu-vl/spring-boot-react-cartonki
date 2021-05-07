<template>
  <div class="login-page">
    <div class="p-grid">
      <div class="p-col-12 p-md-4 p-col-offset-0 p-md-offset-4">
        <form @submit.prevent="submitLogin()">
          <Card>
            <template #header><h1 class="p-text-center">Sign In</h1></template>
            <template #title>Welcome to our application!</template>
            <template #content>
              <div class="p-field p-grid">
                <label for="email" class="p-col-fixed" style="width: 100px">
                  Email
                </label>
                <div class="p-col">
                  <InputText
                    id="email"
                    type="email"
                    v-model="user.email"
                    style="width: 100%"
                  />
                </div>
              </div>
              <div class="p-field p-grid">
                <label for="password" class="p-col-fixed" style="width: 100px">
                  Password
                </label>
                <div class="p-col">
                  <InputText
                    id="password"
                    type="password"
                    v-model="user.password"
                    style="width: 100%"
                  />
                </div>
              </div>
            </template>
            <template #footer>
              <div class="p-d-flex p-jc-end">
                <Button
                  type="submit"
                  icon="pi pi-check"
                  label="Confirm"
                  class="p-button-success"
                />
                <Button
                  icon="pi pi-chevron-right"
                  label="Sign Up"
                  class="p-button-primary p-ml-3"
                  @click="$router.push('registration')"
                />
              </div>
            </template>
          </Card>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      user: {
        email: "",
        password: "",
      },
    };
  },
  methods: {
    submitLogin() {
      this.$store.dispatch("auth/login", this.user);
    },
  },
};
</script>

<style>
</style>