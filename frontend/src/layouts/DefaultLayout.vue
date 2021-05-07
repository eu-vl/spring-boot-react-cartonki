<template>
  <div class="default-layout">
    <Menubar :model="items">
      <template #start>
        <img
          alt="logo"
          src="../assets/logo.png"
          height="50"
          class="p-mr-2"
        />
      </template>
    </Menubar>
    <router-view/>
  </div>
</template>

<script>
import menuBar from '../mixins/menuBar.mixin'
export default {
  name: "DefaultLayout",
  mixins: [menuBar],
  
};
</script>

<style>

</style>