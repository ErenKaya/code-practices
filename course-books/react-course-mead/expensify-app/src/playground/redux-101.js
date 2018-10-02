import { createStore } from 'redux';

/**
 * Reducers
 * 
 */

const countReducer = (state = { count: 0 }, action) => {
    switch (action.type) {
        case 'INCREMENT':
            const incrementBy = typeof action.incrementBy === 'number' ? action.incrementBy : 1
            return {
                count: state.count + incrementBy
            }
        case 'DECREMENT':
            const decrementBy = typeof action.decrementBy === 'number' ? action.decrementBy : 1
            return {
                count: state.count - decrementBy
            }
        case 'SET':
            const countValue = typeof action.countValue === 'number' ? action.countValue : 0
            return {
                count: countValue
            }
        case 'RESET':
            return {
                count: 0
            }
        default:
            return state;
    }
}

const store = createStore(countReducer);


const incrementCount = ({ incrementBy = 1 } = {}) => (
    {
        type: 'INCREMENT',
        incrementBy
    }
);

const decrementCount = ({ decrementBy = 1 } = {}) => (
    {
        type: 'DECREMENT',
        decrementBy
    }
);

const setCount = ({ countValue = 0 } = {}) => (
    {
        type: 'SET',
        countValue
    }
);

const resetMethod = () => (
    {
        type: 'RESET'
    }
);


store.subscribe(() => {
    console.log(store.getState());

});

store.dispatch(incrementCount());

store.dispatch(incrementCount({ incrementBy: 5 }));

store.dispatch(decrementCount());

store.dispatch(decrementCount({ decrementBy: 9 }));

store.dispatch(setCount({ countValue: 55 }));
store.dispatch(resetMethod());



