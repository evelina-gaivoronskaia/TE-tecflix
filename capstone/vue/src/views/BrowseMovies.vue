<template>
  <div>
    <!-- <filter-movies /> -->
    <movie-card />
    <!-- <movie-card-two/> -->
  </div>
</template>

<script>
// // import MovieList from '@/components/MovieList';
// import FilterMovies from "../components/FilterInput.vue";
import MovieCard from "../components/MovieCard.vue";

// import MovieCardTwo from '../components/MovieCard2.vue'
export default {
  name: "browse-movies",
  components: {
    // MovieList,
    // FilterMovies,
    MovieCard,
    // MovieCardTwo
  },
};
</script>

<style scoped>
/* @import url("https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Monoton&display=swap");
@import url("https://fonts.googleapis.com/css2?family=Monoton&display=swap"); */

.browse {
  display: flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
  /* background: blueviolet; */
}
</style>