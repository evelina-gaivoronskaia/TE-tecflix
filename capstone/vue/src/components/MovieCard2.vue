<template>
  <div class="card" v-bind:class="{ seen: movie.seen }">
    <h1>Movies</h1>
    <h2 class="title">{{ movie.title }}</h2>
    <img v-bind:src="'http://image.tmdb.org/t/p/w185' + movie.poster_path" id="movie"/>
    
    <div class="button-container" v-if="! enableAdd">
        <button class="mark-seen" v-on:click.prevent="setRead(true)" v-if=" ! movie.seen">Mark Read</button>
        <button class="mark-seen" v-on:click.prevent="setRead(false)" v-if="movie.unseen">Mark Unread</button>
    </div>
    <button v-if="enableAdd" v-on:click.prevent="addToFavoriteList(movie)">Add to  List</button>
    
  </div>

</template>

<script>
import MovieService from "../services/MovieService"
export default {
    name: 'movie-card-2',
    props: {
        movie: Object,
        enableAdd: {
            type: Boolean,
            default: false
        }
    },
    methods: {
        getAllMovie(){
            MovieService.getAllMovies().then((response)=>{
                if(response.status == 200){
                    this.movies =response.data;
                }
            });
        },
        setSeen(value) {
            this.$store.commit('SET_SEEN_STATUS', {movie: this.movie, value: value});
        },
        
    }
}
</script>

<style>
.card {
    border: 2px solid black;
    border-radius: 10px;
    width: 250px;
    height: 550px;
    margin: 20px;
}

.card.read {
    background-color: lightgray;
}

.card .book-title {
    font-size: 1.5rem;
}

.card .title {
    font-size: 1rem;
}
</style>