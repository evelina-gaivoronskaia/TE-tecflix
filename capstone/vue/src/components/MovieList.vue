<template>
  <div>
    <div
      class="movie"
      :key="movie.movie_id"
      v-for="movie in this.$store.state.movies"
    >
      <router-link id="title" :to="{ name: 'movieCard' }">
        {{ movie.title }}
      </router-link>
      <h2>{{ movie.release_date }}</h2>
      <img
        v-if="movie.poster_path"
        class="movie_img"
        v-bind:src="'http://image.tmdb.org/t/p/w185' + movie.poster_path"
      />
      <h3>{{ movie.overview }}</h3>
    </div>
  </div>
</template>

<script>
import movieService from "../services/MovieService";

export default {
  // data() {
  //   return {
  //     httpPath: "http://image.tmbd.org/t/p/w185/",
  //   };
  // },
  created() {
    this.retrieveMovies();
  },

  methods: {
    retrieveMovies() {
      movieService
        .getAllMovies()
        .then((response) => {
          this.$store.commit("SET_MOVIES", response.data);
        })
        .catch((error) => {
          if (error.response.status === 400) {
            console.log("Client error");
          } else if (error.response.status === 500) {
            console.log("Server error");
          } else {
            console.log(error);
          }
        });
    },
  },
};
</script>

<style>
.movie {
  display: flex;
  justify-content: center;
  background-color: #010130;
  color: aliceblue;
  flex-direction: column;
  flex-wrap: wrap;
  padding: 10px, 20px, 10px, 20px;
  border-radius: 15px 50px;
  margin: 30px 30px 30px 30px;
  opacity: 80%;
  width: 45em;
  text-align: center;
}
#title {
  color: aliceblue;
  font-size: 35px;
}
</style>