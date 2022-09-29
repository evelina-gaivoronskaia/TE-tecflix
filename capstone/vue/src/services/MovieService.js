import axios from 'axios';

export default {

    getAllMovies() {
        return axios.get('/movies')
    },

    getMovies() {
        return axios.get('/movies/${movieId}')
    }



}