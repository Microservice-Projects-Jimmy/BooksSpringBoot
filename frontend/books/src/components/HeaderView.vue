<template>
    <q-header elevated>
        <q-toolbar class="header--toolbar text-h5">

            <q-toolbar-title class="text-h4">
                Welcome To Library
            </q-toolbar-title>

            <q-btn flat no-caps :to="name == '' ? '/sign-in': ''">{{name ==
            ''?'Sign In'
            : name}}


            </q-btn>

            <q-btn flat round dense icon="account_circle" size="large" @click="openMenu()">
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
import { ref } from 'vue'
import { useRouter } from 'vue-router';
import axios from 'axios';

const menuShow = ref(false)
const store = useUserStore();
const { name } = storeToRefs(store);
const router = useRouter();
function openMenu() {
    if (name.value == '') {
        menuShow.value = true
    }
}

function Logout() {
    const token = localStorage.getItem('token')?.toString();
    axios.post('http://localhost:8080/logout', {}, { headers: { Authorization: `${token}` } }).then(() => {
        store.deleteUser();
        store.setName('');
        router.push('/')
    })
}
</script>