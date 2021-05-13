<template>
  <div class="home">
    <div class="p-grid p-mt-3">
      <div class="p-col-12 p-xl-7">
        <rooms-table />
      </div>
      <div class="p-col-12 p-xl-5"><menu-card/></div>
    </div>
  </div>
</template>

<script>
import MenuCard from '../components/home/menuCard.vue';
import roomsTable from "../components/home/roomsTable.vue";
export default {
  components: { roomsTable, MenuCard },
  name: "Home",
};
</script>
