import { createStore, combineReducers } from 'redux';
import uuid from 'uuid';


//ADD_EXPENSE
const addExpense = (
    {
        description = '',
        note = '',
        amount = 0,
        createdAt = 0
    } = {}
) => ({
    type: 'ADD_EXPENSE',
    expense: {
        id: uuid(),
        description,
        note,
        amount,
        createdAt
    }
});

//REMOVE_EXPENSE
const removeExpense = ({ id } = {}) => ({
    type: 'REMOVE_EXPENSE',
    id
});

//EDIT_EXPENSE

const editExpense = (id, updates) => ({
    type: 'EDIT_EXPENSE',
    id,
    updates
});

//SET_TEXT_FILTER
const setTextFilter = (text = '') => ({
    type: 'SET_TEXT_FILTER',
    text
});



const expensesReducerDefaultState = [];


const expensesReducer = (state = expensesReducerDefaultState, action) => {
    switch (action.type) {
        case 'ADD_EXPENSE':
            return [
                ...state,
                action.expense
            ];
        case 'REMOVE_EXPENSE':
            return state.filter(({ id }) => id !== action.id)
        case 'EDIT_EXPENSE':
            return state.map((expense) => {
                if (expense.id === action.id) {
                    return {
                        ...expense,
                        ...action.updates
                    };
                } else {
                    return expense;
                }
            });
        default:
            return state;
    }
};

const filtersReducerDefaultState = {
    text: '',
    sortBy: 'date',
    startDate: undefined,
    endDate: undefined
}

const filtersReducer = (state = filtersReducerDefaultState, action) => {
    switch (action.type) {
        case 'SET_TEXT_FILTER':
            return {
                ...state,
                text: action.text
            };
        default:
            return state;
    }
};

const demoState = {
    expenses: [{
        id: 'askdakmsd',
        description: 'January Rent',
        note: 'This was the final payment for that address',
        amount: 54500,
        createdAt: 0
    }
    ],
    filters: {
        text: 'rent',
        sortBy: 'amount', //date or amount
        startDate: undefined,
        endDate: undefined
    }
};

const store = createStore(combineReducers({
    expenses: expensesReducer,
    filters: filtersReducer
}));

store.subscribe(() => {
    console.log(store.getState());
});
const expenseOne = store.dispatch(addExpense({
    description: 'Rent',
    amount: 160,
}));
const expenseTwo = store.dispatch(addExpense({
    description: 'Coffee',
    amount: 16,
}));

store.dispatch(removeExpense({ id: expenseTwo.expense.id }));
store.dispatch(editExpense(expenseOne.expense.id, { amount: 500 }));
store.dispatch(setTextFilter('rent'));


// /**
//  * Reducers
//  * 
//  */

// const countReducer = (state = { count: 0 }, action) => {
//     switch (action.type) {
//         case 'INCREMENT':
//             const incrementBy = typeof action.incrementBy === 'number' ? action.incrementBy : 1
//             return {
//                 count: state.count + incrementBy
//             }
//         case 'DECREMENT':
//             const decrementBy = typeof action.decrementBy === 'number' ? action.decrementBy : 1
//             return {
//                 count: state.count - decrementBy
//             }
//         case 'SET':
//             const countValue = typeof action.countValue === 'number' ? action.countValue : 0
//             return {
//                 count: countValue
//             }
//         case 'RESET':
//             return {
//                 count: 0
//             }
//         default:
//             return state;
//     }
// }

// const store = createStore(countReducer);


// const incrementCount = ({ incrementBy = 1 } = {}) => (
//     {
//         type: 'INCREMENT',
//         incrementBy
//     }
// );

// const decrementCount = ({ decrementBy = 1 } = {}) => (
//     {
//         type: 'DECREMENT',
//         decrementBy
//     }
// );

// const setCount = ({ countValue = 0 } = {}) => (
//     {
//         type: 'SET',
//         countValue
//     }
// );

// const resetMethod = () => (
//     {
//         type: 'RESET'
//     }
// );


// store.subscribe(() => {
//     console.log(store.getState());

// });

// store.dispatch(incrementCount());

// store.dispatch(incrementCount({ incrementBy: 5 }));

// store.dispatch(decrementCount());

// store.dispatch(decrementCount({ decrementBy: 9 }));

// store.dispatch(setCount({ countValue: 55 }));
// store.dispatch(resetMethod());

