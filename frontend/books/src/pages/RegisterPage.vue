<template>
    <q-card class="absolute-center register">
        <div class="text-center text-h6"> Register </div>
        <q-card-section>
            <q-input v-model="name" standout label="Name" outlined class="q-mb-lg" />
            <q-input v-model="username" standout label="Username" outlined class="q-mb-lg" />
            <q-input v-model="password" type="password" outlined label="Password" />
            <q-card-actions class="row justify-between sign-in--actions">
                <q-btn to="/sign-in" color="primary">sign in</q-btn>
                <q-btn color="primary" @click="register">register</q-btn>
            </q-card-actions>
        </q-card-section>
    </q-card>
</template>

<script setup lang="ts">
import axios from 'axios';
import { reactive, ref } from 'vue'
import { useRouter } from 'vue-router';
import { useQuasar } from 'quasar';

const $q = useQuasar();

const name = ref("");
const username = ref("");
const password = ref("");
const form = reactive({
    name,
    username,
    password
});

const router = useRouter();

function showNotif(message: string, type: string) {
    $q.notify({
        message: message,
        type: type
    })
}

function register() {
    axios.post('http://localhost:8080/register', form).then((res) => {
        router.push('/sign-in')
        showNotif('You have successfully registered', 'positive')
        showNotif('Now Sign in', 'positive')

    }).catch(function (error) {
        if (error.response) {
            showNotif(error.response.data.message, 'negative');
        }
    });
}


</script>