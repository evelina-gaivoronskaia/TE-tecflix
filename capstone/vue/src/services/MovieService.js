import axios from 'axios';

export default {

    getAllMovies() {
        return axios.get(`/movies`)
    },

    getMovie(movieId) {
        return axios.get(`/movies/${movieId}`)
    },

    updateMovie(movie, movieId) {
        return axios.put(`/movies/${movieId}`, movie)
    }

}