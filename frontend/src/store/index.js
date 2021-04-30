import { createStore } from 'vuex'
import auth from "./modules/auth.module"
export default createStore({
  modules: 
  {
  auth,
  }
})
