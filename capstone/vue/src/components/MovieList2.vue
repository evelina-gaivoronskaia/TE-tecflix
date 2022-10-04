<template>
  <div class ="movie-container">
      <movie-card-2 v-for="movie in movies" v-bind:key="movie.title" class="movie-details">

</div>
</template>


<script>
import MovieCard2 from './MovieCard2.vue'
import MovieService from '../services/MovieService'
export default {
  name:" movie-list-2",
  components: { MovieCard2 
  },
   data() {
    return {
      movie: {
        movie_id: "",
        title: "",
        release_date: "",
        summary: "",
        movie_img: "",
      },
      movies: [],
    };
   },
      getMovies(){
        MovieService.getAllMovies().then((response)=>{
            if(response.status ==200){
                this.$store.commit('SET_MOVIES',response.data)
            }
        });

    },




methods:{
 
    retrieveMovie(){
        MovieService.getMovie(this.$route.params.id)
    }
}
}
</script>

<style>

</style>