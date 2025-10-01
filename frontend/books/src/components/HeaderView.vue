<template>
  <q-header class="header">
    <q-toolbar class="header--toolbar text-h5">
      <q-toolbar-title class="title" @click="router.push('/')">
        Jimmy Shop
      </q-toolbar-title>

      <q-list class="row items-center text-uppercase header--menu">
        <q-btn flat>Home</q-btn>
        <q-btn flat>Explore</q-btn>
        <q-btn flat>Shop</q-btn>
        <q-btn flat>Sell your book</q-btn>
      </q-list>

      <q-btn
        flat
        round
        dense
        icon="account_circle"
        size="large"
        @click="router.push(name == '' ? '/sign-in' : '/account')"
      >
        <q-menu v-model="menuShow">
          <q-list style="min-width: 100px">
            <q-item clickable v-close-popup to="/account">
              <q-item-section>My Books</q-item-section>
            </q-item>
            <q-separator />
            <q-item clickable v-close-popup @click="Logout()">
              <q-item-section>Logout</q-item-section>
            </q-item>
          </q-list>
        </q-menu>
      </q-btn>
    </q-toolbar>
  </q-header>
</template>

<script setup lang="ts">
import { useUserStore } from 'src/stores/user-store';
import { storeToRefs } from 'pinia';
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import axios from 'axios';

const menuShow = ref(false);
const store = useUserStore();
const { name } = storeToRefs(store);
const router = useRouter();
function openMenu() {
  if (name.value == '') {
    menuShow.value = true;
  }
}

function Logout() {
  const token = localStorage.getItem('token')?.toString();
  axios
    .post(
      'http://localhost:8080/logout',
      {},
      { headers: { Authorization: `${token}` } }
    )
    .then(() => {
      store.deleteUser();
      store.setName('');
      router.push('/');
    });
}
</script>

<style scoped lang="scss">
.header {
  --font-size: 18px;
  --font-weight: 700;
  color: #000000;
  padding: 50px 150px;

  &--menu {
    font-size: var(--font-size);
    font-weight: var(--font-weight);
    .q-item:hover {
      cursor: pointer;
    }
  }
}

.title {
  font-size: calc(var(--font-size) * 2 - 4px);
  font-weight: var(--font-weight);
  &:hover {
    cursor: pointer;
  }
}
</style>
