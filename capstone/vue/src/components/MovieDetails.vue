<template>
  <div>
    <h2 class="title">{{ movie.title }}</h2>
    <h3 class="release-date">{{ movie.release_date }}</h3>
    <img v-bind:src="movie.movie_img" class="movie_img" />
    <p class="summary">{{ movie.summary }}</p>
  </div>
</template>

<script>
import movieService from "../services/MovieService";

export default {
  data() {
    return {
      movie: {
        movie_id: "",
        title: "",
        release_date: "",
        summary: "",
        movie_img: "",
      },
    };
  },
  created() {
    movieService.getMovie(this.$route.params.movieId).then((response) => {
      this.movie = response;
    });
  },
};
</script>

<style>
</style>