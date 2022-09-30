<template>
  <!-- <div class="card" v-on:click="getMovie" v-bind:to="{name: 'movie-details'}"> -->
    <div class ="card" v-bind:class="{seen: movie.seen}">
  
    <div class="movie-details">
      <h2 class="title">{{ movie.title }}</h2>
      <img v-bind:src="movie.movie_img" class="movie_img" />
      <h3 class= "genre">{{movie.genre}} </h3>
      <p class="release-date">{{ movie.release_date }}</p>
      <p class="summary">{{ movie.summary }}</p>
    </div>
  </div>
</template>


<script>
import MovieService from "../services/MovieService";

export default {
  name: "movie-card",
  props: {
    movie: Object,
    enableAdd:{
      type:Boolean,
      default:false
      
    }
  },
  
  methods: {
    // getMovies() {
    //     MovieService.getAllMovies().then(response => {
    //        if (response.status === 200) {
    //            this.movies = response.data;
    //        }
    //     });
    // },
    created() {
      MovieService.getMovie(this.$route.params.movie_id);
    },
    setSeen(value){
      this.$sore.commit('SET_SEEN_STATUS',{movie: this.movie, value:value})
    }
  },
  // data() {
  //   return {
  //     movie: {
  //       movie_id: "",
  //       title: "",
  //       release_date: "",
  //       summary: "",
  //       movie_img: "",
  //       genre:""
  //     },
  //     movies: [],
  //   };
  // },
  created() {
    this.grabMovie();
  },
};
</script>

<style>

.card{
   border: 2px solid black;
    border-radius: 10px;
    width: 250px;
    height: 550px;
    margin: 20px;
}
.movie-card {
  /* display: flex;
    justify-content: center;
    background: white;
    flex-direction: column;
    flex-wrap: wrap;
    padding: 10px, 20px, 10px, 20px;
    border-radius: 15px 50px;
    opacity: 80%;
    width: 500px;
    text-align: center; */
  display: flex;
  justify-content: center;
  background-color: #010130;
  flex-direction: column;
  flex-wrap: wrap;
  padding: 10px, 20px, 10px, 20px;
  border-radius: 15px 50px;
  opacity: 80%;
  width: 45em;
  text-align: center;
}
#movie-display {
  display: flex;
  margin: 20px;
  align-items: center;
}
h4 {
  margin: 10%;
}
.movie-info {
  display: flex;
  flex-direction: column;
  align-content: space-around;
}
table {
  margin: 10%;
}
/* img {
    max-height: 600px;
} */
</style>