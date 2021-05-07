import AuthService from '../services/auth.service';
import router from '../../router'
const user = JSON.parse(localStorage.getItem('user'));
const initialState = user ? { status: { loggedIn: true }, user } : { status: { loggedIn: false }, user: null };
const auth = {
    namespaced: true,
    state: initialState,
    actions: {
        login({ commit }, user) {
            AuthService.login(user)
        },
        logout({ commit }) {
            AuthService.logout();
            commit('logout');
            router.replace('auth')
        },
        registration({ commit }, user) {
            console.log(user)
            AuthService.registration(user)
            commit('registerSuccess');
        }
    },
    mutations: {
        loginSuccess(state, user) {
            state.status.loggedIn = true;
            state.user = user
        },
        loginFailure(state) {
            state.status.loggedIn = false;
            state.user = null;
        },
        logout(state) {
            state.status.loggedIn = false;
            state.user = null;
        },
        registerSuccess(state) {
            state.status.loggedIn = false;
        },
        registerFailure(state) {
            state.status.loggedIn = false;
        }
    }
};
export default auth;