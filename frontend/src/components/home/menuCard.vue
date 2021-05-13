<template>
  <Card>
    <template #title> Dashboard Menu </template>
    <template #content>
      <div class="menu-content p-text-center">
        <span class="p-buttonset">
          <Button label="Save" icon="pi pi-check" />
          <Button label="Delete" icon="pi pi-trash" />
          <Button label="Cancel" icon="pi pi-times" />
        </span>
      </div>
    </template>
  </Card>
</template>

<script>
export default {
  name: "MenuCard",
};
</script>

<style>
</style>