import axios from 'axios';

export default {

    getAllMovies() {
        return axios.get(`/movies`)
    },

    getMovie(movieId) {
        return axios.get(`/movies/${movieId}`)
    }

}