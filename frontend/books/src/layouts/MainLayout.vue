<template>
  <q-layout view="hHh Lpr lFf">
    <HeaderView></HeaderView>

    <q-page-container>
      <router-view />
    </q-page-container>
  </q-layout>
</template>

<script setup lang="ts">
import HeaderView from 'src/components/HeaderView.vue';

import { useUserStore } from 'src/stores/user-store';
import { storeToRefs } from 'pinia';

const store = useUserStore();
const { name, username } = storeToRefs(store);

</script>


