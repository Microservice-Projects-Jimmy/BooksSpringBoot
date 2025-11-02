<template>
  <header class="header">
    <section class="text-2xl font-bold title">Jimmy Shop</section>
    <section class="header--menu">
      <ul>
        <li class="item">HOME</li>
        <li class="item">EXPLORE</li>
        <li class="item">SHOP</li>
        <li class="item">SELL YOUR BOOK</li>
        <li class="item">
          <div class="account">
            <span>
              <svg
                width="27"
                height="27"
                viewBox="0 0 27 27"
                fill="none"
                xmlns="http://www.w3.org/2000/svg"
              >
                <path
                  d="M13.3333 0C15.1014 0 16.7971 0.702379 18.0474 1.95262C19.2976 3.20286 20 4.89856 20 6.66667C20 8.43478 19.2976 10.1305 18.0474 11.3807C16.7971 12.631 15.1014 13.3333 13.3333 13.3333C11.5652 13.3333 9.86953 12.631 8.61929 11.3807C7.36905 10.1305 6.66667 8.43478 6.66667 6.66667C6.66667 4.89856 7.36905 3.20286 8.61929 1.95262C9.86953 0.702379 11.5652 0 13.3333 0ZM13.3333 16.6667C20.7 16.6667 26.6667 19.65 26.6667 23.3333V26.6667H0V23.3333C0 19.65 5.96667 16.6667 13.3333 16.6667Z"
                  fill="black"
                />
              </svg>
            </span>
            <span class="notification"> {{ notificationCount }} </span>
          </div>
        </li>
      </ul>
    </section>
  </header>
</template>

<script setup lang="ts">
import { ref } from 'vue'

const notificationCount = ref(15)
</script>

<style scoped lang="scss">
.header {
  --font-size: 18px;
  --font-weight: 700;
  color: #000000;
  background-color: transparent;
  display: flex;
  justify-content: space-between;
  margin-bottom: 130px;

  &--menu {
    font-size: var(--font-size);
    font-weight: var(--font-weight);
    .item:hover {
      cursor: pointer;
    }
    ul {
      list-style-type: none;
      padding: 0;
      margin: 0;
      display: flex;
      gap: 55px; /* Fixed typo by removing the extra 'px' */
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
.account {
  width: 40px;
  height: 40px;
  position: relative;
}
.notification {
  position: absolute;
  background-color: red;
  border-radius: 50%;
  padding: 5px;
  font-size: 14px;
  color: #fff;
  width: 21px;
  height: 21px;
  display: flex;
  align-items: center;
  justify-content: center;
  top: -10px;
  right: 0;
}
</style>
