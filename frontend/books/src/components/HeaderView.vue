<template>
    <q-header elevated>
        <q-toolbar class="header--toolbar text-h5">

            <q-toolbar-title class="text-h4">
                Welcome To Library
            </q-toolbar-title>

            <q-btn flat no-caps to="/sign-in">{{account}}</q-btn>

            <q-btn flat round dense icon="account_circle" size="large" />
        </q-toolbar>
    </q-header>
</template>

<script setup lang="ts">
const account = "Sign In"
</script>