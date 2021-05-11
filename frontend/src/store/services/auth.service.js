import axios from 'axios';
import store from "../../store"
import router from "../../router"
const API_URL = 'http://localhost:8080/auth/';

class AuthService {
    registration(user) {
        console.log(user)
        const formData = new FormData()
        formData.append("firstName", user.firstName)
        formData.append("secondName", user.secondName)
        formData.append("email", user.email)
        formData.append("password", user.password)
        axios({
            method: "post",
            url: API_URL + 'registration',
            data: formData,
            headers: {
                "Access-Control-Allow-Origin": "*",
            },
        })
            .then(function (response) {
                if (response.status !== 200) {
                    router.replace("registration")
                }
                router.replace("login")
                console.log(response)
            })
            .catch(function (error) {
                console.log(error)
            })
    }
    login(user) {
        const formData = new FormData()
        formData.append("email", user.email)
        formData.append("password", user.password)
        axios({
            method: "post",
            url: API_URL + 'login',
            data: formData,
            headers: {
                "Access-Control-Allow-Origin": "*"
            },
        })
            .then(function (response) {
                if (response.data.token) {
                    localStorage.setItem("user", JSON.stringify(response.data))
                    store.commit("auth/loginSuccess", response.data)
                }
            })
            .then(() => router.replace("/"))
            .catch(function (error) {
                console.log(error)
            })
    }
    logout() {
        localStorage.removeItem('user')
    }
}

export default new AuthService()