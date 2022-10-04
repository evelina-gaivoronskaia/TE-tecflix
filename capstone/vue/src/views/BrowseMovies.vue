<template>
  <div>
      <movie-card />
      <!-- <movie-card-two/> -->

  </div>
</template>

<script>
// // import MovieList from '@/components/MovieList';
import MovieCard from '../components/MovieCard.vue';
// import MovieCardTwo from '../components/MovieCard2.vue'
export default {
    name: 'browse-movies',
    components: {
        // MovieList,
        MovieCard,
        // MovieCardTwo
    }
}
</script>

<style scoped>

</style>