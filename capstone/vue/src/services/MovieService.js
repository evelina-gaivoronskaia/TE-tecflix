import axios from 'axios';

export default {

    getAllMovies() {
        return axios.get(`/browseMovies`)
    },

    getMovie(movieId) {
        return axios.get(`/movies/${movieId}`)
    },

    updateMovie(movie, movieId) {
        return axios.put(`/movies/${movieId}`, movie)
    },

    getFavoriteMovies() {
        return axios.get(`/browseMovies/favorite`)
    }

}