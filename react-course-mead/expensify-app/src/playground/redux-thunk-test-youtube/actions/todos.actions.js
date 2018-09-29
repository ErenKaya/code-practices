export const ADD_TODO = 'ADD_TODO'

export const addNewTodo = (newTodo) => {
  return {
    type: ADD_TODO,
    payload: newTodo
  }
}