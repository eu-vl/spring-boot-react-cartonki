// Vue
import { createApp } from 'vue'
import App from './App.vue'
import './registerServiceWorker'
import router from './router'
import store from './store'

import PrimeVue from 'primevue/config';
import "primevue/resources/themes/saga-blue/theme.css" 
import "primeicons/primeicons.css"
import "primevue/resources/primevue.min.css" 
import 'primeflex/primeflex.css';

import InputText from 'primevue/inputtext';
import Card from 'primevue/card';
import Button from 'primevue/button'



const app = createApp(App);


app
.use(store)
.use(router)
.use(PrimeVue, {ripple: true})


app
.component("InputText", InputText)
.component("Card", Card)
.component("Button",Button)

app.mount('#app')
