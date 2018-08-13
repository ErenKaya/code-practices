import React from 'react';
import { Provider } from 'react-redux';
import ReactDOM from 'react-dom';
import AppRouter from './routers/AppRouter';
import configureStore from './store/configureStore';
import { addExpense, removeExpense } from './actions/expenses';
import { setTextFilter } from './actions/filters';
import getVisibleExpenses from './selectors/expenses';


const store = configureStore();

const expenseOne = store.dispatch(addExpense({
    description: 'Water Bill',
    amount: 160,
    createdAt: -21000
}));
const expenseTwo = store.dispatch(addExpense({
    description: 'Gas Bill',
    amount: 160,
    createdAt: -21000
}));
store.dispatch(setTextFilter('asd1122122'));

setTimeout(() => {
    store.dispatch(setTextFilter('1'));
}, 3000);



const state = store.getState();
const visibleExpenses = getVisibleExpenses(state.expenses, state.filters);
console.log(visibleExpenses);
const jsx = (
    <Provider store={store}>
        <AppRouter />
    </Provider>
);

ReactDOM.render(jsx, document.getElementById('app'));