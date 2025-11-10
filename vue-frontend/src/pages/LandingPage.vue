<template>
  <div class="landing-page">
    <div class="background-fone"></div>
    <Header />
    <div class="page-top">
      <div>
        <section class="intro">
          <span>Buy and sell your books </span>
          <span>for the best prices</span>
        </section>
        <section class="sub-info">
          Find and read more yuor’ll love, and keep track of the books you want to read. Be part of
          the word’s largeest community of book lovers on Goodreads.
        </section>
        <section>
          <form>
            <div class="form-control">
              <span class="search-icon">
                <svg
                  width="22"
                  height="22"
                  viewBox="0 0 22 22"
                  fill="none"
                  xmlns="http://www.w3.org/2000/svg"
                >
                  <path
                    d="M20.7538 18.9612L15.9758 14.1832C17.1261 12.6518 17.7471 10.7878 17.745 8.8725C17.745 3.98023 13.7648 0 8.8725 0C3.98023 0 0 3.98023 0 8.8725C0 13.7648 3.98023 17.745 8.8725 17.745C10.7878 17.7471 12.6518 17.1261 14.1832 15.9758L18.9612 20.7538C19.2031 20.97 19.5185 21.0854 19.8428 21.0763C20.1671 21.0673 20.4756 20.9344 20.705 20.705C20.9344 20.4756 21.0673 20.1671 21.0763 19.8428C21.0854 19.5185 20.97 19.2031 20.7538 18.9612ZM2.535 8.8725C2.535 7.61906 2.90669 6.39377 3.60306 5.35157C4.29943 4.30938 5.28922 3.49708 6.44724 3.01741C7.60527 2.53774 8.87953 2.41224 10.1089 2.65677C11.3382 2.90131 12.4675 3.5049 13.3538 4.39121C14.2401 5.27753 14.8437 6.40676 15.0882 7.63612C15.3328 8.86547 15.2073 10.1397 14.7276 11.2978C14.2479 12.4558 13.4356 13.4456 12.3934 14.1419C11.3512 14.8383 10.1259 15.21 8.8725 15.21C7.19231 15.208 5.58151 14.5396 4.39344 13.3516C3.20536 12.1635 2.53702 10.5527 2.535 8.8725Z"
                    fill="black"
                  />
                </svg>
              </span>
              <input
                id="search"
                v-model="search"
                class="search"
                placeholder="Search for books..."
              />
              <span
                ><svg
                  width="27"
                  height="4"
                  viewBox="0 0 27 4"
                  fill="none"
                  xmlns="http://www.w3.org/2000/svg"
                >
                  <path
                    d="M1.96032 3.90413C1.42125 3.90413 0.958422 3.71355 0.571822 3.3324C0.190666 2.9458 8.88407e-05 2.48297 8.88407e-05 1.9439C8.88407e-05 1.41029 0.190666 0.952899 0.571822 0.571744C0.958422 0.190589 1.42125 1.0848e-05 1.96032 1.0848e-05C2.48304 1.0848e-05 2.94043 0.190589 3.33248 0.571744C3.72452 0.952899 3.92054 1.41029 3.92054 1.9439C3.92054 2.30328 3.82798 2.63271 3.64284 2.93218C3.46316 3.22622 3.2263 3.46308 2.93226 3.64277C2.63823 3.81701 2.31425 3.90413 1.96032 3.90413ZM13.348 3.90413C12.8089 3.90413 12.3461 3.71355 11.9595 3.3324C11.5784 2.9458 11.3878 2.48297 11.3878 1.9439C11.3878 1.41029 11.5784 0.952899 11.9595 0.571744C12.3461 0.190589 12.8089 1.0848e-05 13.348 1.0848e-05C13.8707 1.0848e-05 14.3281 0.190589 14.7202 0.571744C15.1122 0.952899 15.3082 1.41029 15.3082 1.9439C15.3082 2.30328 15.2157 2.63271 15.0305 2.93218C14.8509 3.22622 14.614 3.46308 14.32 3.64277C14.0259 3.81701 13.7019 3.90413 13.348 3.90413ZM24.7357 3.90413C24.1966 3.90413 23.7338 3.71355 23.3472 3.3324C22.9661 2.9458 22.7755 2.48297 22.7755 1.9439C22.7755 1.41029 22.9661 0.952899 23.3472 0.571744C23.7338 0.190589 24.1966 1.0848e-05 24.7357 1.0848e-05C25.2584 1.0848e-05 25.7158 0.190589 26.1079 0.571744C26.4999 0.952899 26.6959 1.41029 26.6959 1.9439C26.6959 2.30328 26.6034 2.63271 26.4182 2.93218C26.2385 3.22622 26.0017 3.46308 25.7077 3.64277C25.4136 3.81701 25.0896 3.90413 24.7357 3.90413Z"
                    fill="black"
                  />
                </svg>
              </span>
            </div>
          </form>
        </section>
      </div>
      <div>
        <img src="@/assets/images/main.png" alt="cover books" width="480" height="500" />
      </div>
    </div>
    <section class="best-sellers"><Courusel title="Best Seller" :books="books" /></section>
    <section class="advertisement">
      <Explore />
    </section>
    <section class="award w-full">
      <div class="award-background-fone"></div>
      <div class="flex flex-col gap-10">
        <span class="text">2025 National Book Awards for Fiction Shortlist</span>
        <button>Explore Now</button>
      </div>
      <img src="@/assets/images/award.png" alt="Award Image" />
    </section>
    <section class="new-releases">
      <Courusel title="New Realeses" :books="books" />
    </section>
    <section class="subscribe">
      <div class="flex flex-col w-1/2">
        <span>Become Premium</span>
        <span>
          Lorem ipsum dolor sit, amet consectetur adipisicing elit. Quo ad non reprehenderit.
        </span>
        <button>Buy Premium</button>
      </div>
      <div>
        <img src="@/assets/images/subs.png" alt="Premium Subscription" />
      </div>
    </section>
  </div>
  <section>
    <Footer></Footer>
  </section>
</template>

<script setup lang="ts">
import Header from '@/components/HeaderView.vue'
import { ref } from 'vue'
import Courusel from '@/components/CouruselView.vue'
import Explore from '@/components/ExploreView.vue'
import Footer from '@/components/FooterView.vue'

import { books } from '@/shared/dummyDatas/books'

const search = ref('')
</script>
<style scoped lang="scss">
.background-fone {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 1042px;
  background-color: #e4e4e7; /* Example background color */
  z-index: -1;
}
.landing-page {
  --font-size: 18px;
  --font-weight: 500;
  color: #000000;
}

.sub-info {
  max-width: 890px;
  font-size: calc(var(--font-size) + 7px);
  margin-top: 65px;
}

.intro {
  max-width: 770px;
  font-size: calc(var(--font-size) * 4);
  font-weight: calc(var(--font-weight) + 300);
  & span:nth-child(2) {
    color: #6366f1;
  }
}

.page-top {
  position: relative;
  display: flex;
  justify-content: space-between;
}
.form-control {
  display: flex;
  width: 500px;
  height: 55px;
  align-items: center;
  gap: 10px; /* Added gap value */
  background-color: #fff;
  padding-inline: 10px; /* Added padding value */
  margin-top: 55px;
  font-size: calc(var(--font-size) + 7px);
  border-radius: 16px;
  outline: none;
  border: none;
  span:last-child {
    margin-left: auto;
    margin-right: 20px;
  }
}
input:focus {
  outline: none;
}
.best-sellers {
  margin-top: 250px;
}

.advertisement {
  margin-top: 200px;
}
.award {
  position: relative;
  left: 0;
  min-height: 500px;
  margin-top: 150px;
  display: flex;
  align-items: center;
  justify-content: space-between;
  .text {
    font-size: 36px;
    font-weight: 600;
  }
}
.award-background-fone {
  position: absolute;
  background-color: #fef9c3;
  height: 100%;
  width: 100vw;
  left: -150px;
  z-index: -1;
  overflow: hidden;
}
.subscribe {
  margin-top: 120px;
  height: 536px;
  background-color: #fef9c3;
  display: flex;
  padding-inline: 110px;
  justify-content: space-between;
  align-items: center;
  & > div > span:first-child {
    font-size: 56px;
    font-weight: 800;
  }
  & > div > span:nth-child(2) {
    font-size: 26px;
    margin-top: 20px;
    margin-bottom: 90px;
  }
  img {
    width: 578px;
  }
}
button {
  margin-top: auto;
  padding: 10px 20px;
  font-size: 26px;
  background-color: #6366f1;
  color: white;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  max-width: 200px;
}

button:hover {
  background-color: #4f46e5;
}
img {
  width: 470px;
}
</style>
