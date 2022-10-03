<template>
  <div>
    <movie-card/>
      <h1>Hello world</h1>
      <!-- <router-link id="title" :to="{ name: 'movieDetails' }">
        {{ movie.title }}
      </router-link>
      <h2>{{ movie.release_date }}</h2>
      <img
        v-if="movie.poster_path"
        class="movie_img"
        v-bind:src="'http://image.tmdb.org/t/p/w185' + movie.poster_path"
      />
      <h3>{{ movie.overview }}</h3> -->
  </div>
</template>

<script>
import movieService from "../services/MovieService";
// import MovieCard from './MovieCard.vue';

export default {
  components: {
    // MovieCard
  },
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
  justify-content: space-evenly;
  border: 3px solid rgb(255, 72, 0);
  height: 450px;
  width: 350px;
  background-color: #010130;
  color: aliceblue;
  flex-direction: row;
  grid-template: row;
  flex-wrap: wrap;
  padding: 10px, 20px, 10px, 20px;
  border-radius: 15px 50px;
  margin: 30px 30px 30px 30px;
  opacity: 80%;
  text-align: center;
  
}
#title {
  color: aliceblue;
  font-size: 35px;
}
</style>