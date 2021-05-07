<template>
  <div class="home">
    <div class="p-grid">
      <div class="p-col-7">
        <rooms-table />
      </div>
      <div class="p-col-5">Lorem ipsum dolor sit amet.</div>
    </div>
  </div>
</template>

<script>
import roomsTable from "../components/home/roomsTable.vue";
export default {
  components: { roomsTable },
  name: "Home",
};
</script>
