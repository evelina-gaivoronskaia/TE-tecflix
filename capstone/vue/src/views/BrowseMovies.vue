<template>
  <div>
      <movie-card />
  </div>
</template>

<script>
// import MovieList from '@/components/MovieList';
import MovieCard from '../components/MovieCard.vue';
export default {
    name: 'browse-movies',
    components: {
        // MovieList,
        MovieCard
    }
}
</script>

<style scoped>

</style>