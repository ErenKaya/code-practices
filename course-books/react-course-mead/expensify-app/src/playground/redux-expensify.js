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

//SORT_BY_DATE
const sortByDate = () => ({
    type: 'SORT_BY_DATE'
});

//SORT_BY_AMOUNT
const sortByAmount = () => ({
    type: 'SORT_BY_AMOUNT'
});

//SET_START_DATE
const setStartDate = (startDate) => ({
    type: 'SET_START_DATE',
    startDate
});

//SET_END_DATE
const setEndDate = (endDate) => ({
    type: 'SET_END_DATE',
    endDate
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
        case 'SORT_BY_DATE':
            return {
                ...state,
                sortBy: 'amount'
            };
        case 'SORT_BY_AMOUNT':
            return {
                ...state,
                sortBy: 'date'
            }
        case 'SET_START_DATE':
            return {
                ...state,
                startDate: action.startDate
            };
        case 'SET_END_DATE':
            return {
                ...state,
                endDate: action.endDate
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

const getVisibleExpenses = (expenses, { text, sortBy, startDate, endDate }) => {
    return expenses.filter((expense) => {
        const startDateMatch = typeof startDate !== 'number' || expense.createdAt >= startDate;
        const endDateMatch = typeof endDate !== 'number' || expense.createdAt <= endDate;
        const textMatch = expense.description.toLowerCase().includes(text.toLowerCase());

        return startDateMatch && endDateMatch && textMatch;
    }).sort((a, b) => {
        if (sortBy === 'date') {
            return a.createdAt < b.createdAt ? 1 : -1;
        } else if (sortBy === 'amount') {
            return a.amount < b.amount ? 1 : -1;
        }
    });
};


store.subscribe(() => {
    const state = store.getState();
    const visibleExpenses = getVisibleExpenses(state.expenses, state.filters);
    console.log(visibleExpenses);
});
const expenseOne = store.dispatch(addExpense({
    description: 'Rent',
    amount: 160,
    createdAt: -21000
}));
const expenseTwo = store.dispatch(addExpense({
    description: 'Coffee',
    amount: 16,
    createdAt: -1000
}));

// store.dispatch(removeExpense({ id: expenseTwo.expense.id }));
// store.dispatch(editExpense(expenseOne.expense.id, { amount: 500 }));
// store.dispatch(setTextFilter('z'));
// store.dispatch(sortByAmount());
store.dispatch(sortByDate());
// store.dispatch(setStartDate(123));
// store.dispatch(setStartDate());
// store.dispatch(setEndDate(321000));


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

