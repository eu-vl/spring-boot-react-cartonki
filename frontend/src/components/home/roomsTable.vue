<template>
  <div class="rooms-table" style="overflow: auto;">
    <OrderList
      v-model="data"
      dataKey="id"
      breakpoint="200px"
    >
      <template #header> <strong>Rooms</strong> </template>
      <template #item="data">
        <div class="p-caritem"  >
          <div style="display: flex; justify-content: space-between;" >
            <span class="p-caritem-vin"
              ><b>{{ data.item.id }}</b></span
            >
            <span style="min-width: 300px; max-width: 300px">{{
              data.item.title
            }}</span>
            <Button
              icon="pi pi-reply"
              label="Enter"
              class="p-button-primary p-button-sm p-button-rounded"
            />
            <Button
              icon="pi pi-pencil"
              label="Rename"
              class="p-button-secondary p-button-sm p-button-rounded"
            />
            <Button
              icon="pi pi-trash"
              label="Remove"
              class="p-button-danger p-button-sm p-button-rounded"
            />
          </div>
        </div>
      </template>
    </OrderList>
  </div>
</template>

<script>
export default {
  name: "RoomsTable",
  data() {
    return {
      data: [
        { id: 1, title: "First Room" },
        { id: 2, title: "Second Room" },
        { id: 3, title: "Third Room" },
        { id: 3, title: "Third Room" },
        { id: 3, title: "Third Room" },
        { id: 3, title: "Third Room" },
        { id: 3, title: "Third Room" },
        { id: 3, title: "Third Room" },
        { id: 3, title: "Third Room" },
        { id: 3, title: "Third Room" },
        { id: 3, title: "Third Room" },
        { id: 3, title: "Third Room" },
        { id: 3, title: "Third Room" },
        { id: 3, title: "Third Room" },
      ],
    };
  },
};
</script>

<style>
.p-orderlist-controls {
  display: none !important;
}
</style>