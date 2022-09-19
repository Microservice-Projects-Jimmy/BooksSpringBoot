<template>
    <q-card class="absolute-center sign-in--card ">
        <div class="text-center text-h6"> Sign In</div>
        <q-card-section>
            <q-input v-model="username" standout label="Username" outlined class="q-mb-lg" />
            <q-input v-model="password" type="password" outlined label="Password" />
            <q-card-actions class="row justify-between sign-in--actions">
                <q-btn color="primary" @click="signIn">sign in</q-btn>
                <q-btn to="/register" color="primary">register</q-btn>
            </q-card-actions>
        </q-card-section>
    </q-card>
</template>

<script setup lang="ts">
import axios from 'axios';
import { reactive, ref } from 'vue'
import { useUserStore } from 'src/stores/user-store';
import { useRouter } from 'vue-router';
import { useQuasar } from 'quasar';

const store = useUserStore();
const $q = useQuasar();
const router = useRouter();
const username = ref('');
const password = ref('');

const form = reactive({
    username,
    password
});

function showNotif(message: string, type: string) {
    $q.notify({
        message: message,
        type: type
    })
}

function signIn() {
    axios.post('http://localhost:8080/login', form).then((res) => {
        store.setToken(res.data.token);
        store.setName(res.data.name);
        store.setUsername(res.data.username);
        router.push('/library');
    }).catch(function (error) {
        if (error.response) {
            showNotif(error.response.data.message, 'negative');
        }
    });
}
</script>