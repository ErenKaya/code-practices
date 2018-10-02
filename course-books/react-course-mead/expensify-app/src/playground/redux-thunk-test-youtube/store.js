import { applyMiddleware, createStore } from 'redux'
import rootReducer from './reducers'
import logger from 'redux-logger'
import thunkMiddleware from 'redux-thunk'

export default () => {
  console.log("hi from creatin middleware");
  return createStore(
    rootReducer,
    applyMiddleware(logger, thunkMiddleware)
  )
}