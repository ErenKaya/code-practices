import {
    createStore,
    combineReducers
} from 'redux';

const constants = {
    SORT_COLORS: "SORT_COLORS",
    ADD_COLOR: "ADD_COLOR",
    RATE_COLOR: "RATE_COLOR",
    REMOVE_COLOR: "REMOVE_COLOR"
}

/*
Redux achieves modularity via functions. Functions are used to update
parts of the state tree. These functions are called reducers. 4*/

export const color = (state = {}, action) => {
    switch (action.type) {
        case constants.ADD_COLOR:
            return {
                id: action.id,
                title: action.title,
                color: action.color,
                timestamp: action.timestamp,
                rating: 0
            }
        case constants.RATE_COLOR:
            return (state.id !== action.id) ?
                state : {
                    ...state,
                    rating: action.rating
                }
        default:
            return state
    }
}


export const colors = (state = [], action) => {
    switch (action.type) {
        case constants.ADD_COLOR:
            return [
                ...state,
                color({}, action)
            ]
        case constants.RATE_COLOR:
            return state.map(c => color(c, action))
        case constants.REMOVE_COLOR:
            return state.filter(c => c.id !== action.id);
        default:
            return state

    }

}

export const sort = (state = constants.SORT_COLORS, action) => {
    switch (action.type) {
        case constants.SORT_COLORS:
            return action.sortBy
        default:
            return state
    }
}

// const action = {
//     type: "ADD_COLOR",
//     id: "4243e1p0-9abl-4e90-95p4-8001l8yf3036",
//     color: "#0000FF",
//     title: "Big Blue",
//     timestamp: "Thu Mar 10 2016 01:11:12 GMT-0800 (PST)"
// }
// console.log(color({}, action));

// const existingColor = {
//     id: "128e1p5-3abl-0e52-33p0-8401l8yf3036",
//     title: "Big Blue",
//     color: "#0000FF",
//     timestamp: "Thu Mar 10 2016 01:11:12 GMT-0800 (PST)",
//     rating: 0
// }
// const action1 = {
//     type: "RATE_COLOR",
//     id: "4243e1p0-9abl-4e90-95p4-8001l8yf3036",
//     rating: 4
// }
// console.log(color(existingColor, action1));

// const currentColors = [{
//     id: "9813e2p4-3abl-2e44-95p4-8001l8yf3036",
//     title: "Berry Blue",
//     color: "#000066",
//     rating: 0,
//     timestamp: "Thu Mar 10 2016 01:11:12 GMT-0800 (PST)"
// }]

// const action2 = {
//     type: "ADD_COLOR",
//     id: "5523e7p8-3ab2-1e35-95p4-8001l8yf3036",
//     title: "Party Pink",
//     color: "#F142FF",
//     timestamp: "Thu Mar 10 2016 01:11:12 GMT-0800 (PST)"
// }


// const action3 = {
//     type: constants.REMOVE_COLOR,
//     id: "5523e7p8-3ab2-1e35-95p4-8001l8yf3036",

// }

// const action4 = {
//     type: "ADD_COLOR",
//     id: "4",
//     title: "Party Pink",
//     color: "#F142FF",
//     timestamp: "Thu Mar 10 2016 01:11:12 GMT-0800 (PST)"
// }

// console.log(colors(currentColors, action2))
// console.log(colors(currentColors, action3))
// console.log(colors(currentColors, action4))


// const state = "SORTED_BY_DATE";

// const action = {
//     type: constants.SORT_COLORS,
//     sortBy: "SORTED_BY_TITLE"
// }

// console.log(sort(state, action));

// const combinedStore = createStore(
//     combineReducers({colors,sort,color})
// )

// console.log(combinedStore.getState());

const initialState = {
    colors: [{
            id: "3315e1p5-3abl-0p523-30e4-8001l8yf3036",
            title: "Rad Red",
            color: "#FF0000",
            rating: 3,
            timestamp: "Sat Mar 12 2016 16:12:09 GMT-0800 (PST)"
        },
        {
            id: "3315e1p5-3abl-0p523-30e4-8001l8yf4457",
            title: "Crazy Green",
            color: "#00FF00",
            rating: 0,
            timestamp: "Fri Mar 11 2016 12:00:00 GMT-0800 (PST)"
        },
        {
            id: "3315e1p5-3abl-0p523-30e4-8001l8yf2412",
            title: "Big Blue",
            color: "#0000FF",
            rating: 5,
            timestamp: "Thu Mar 10 2016 01:11:12 GMT-0800 (PST)"
        }
    ],
    sort: "SORTED_BY_TITLE"
}
const combinedStore = createStore(
    combineReducers({
        colors,
        sort
    }),
    initialState
)

combinedStore.subscribe(() => {
    console.log('color count', combinedStore.getState().colors.length);
})



console.log(combinedStore.getState().sort);

combinedStore.dispatch({
    type: "ADD_COLOR",
    id: "2222e1p5-3abl-0p523-30e4-8001l8yf2222",
    title: "Party Pink",
    color: "#F142FF",
    timestamp: "Thu Mar 10 2016 01:11:12 GMT-0800 (PST)"
});



combinedStore.dispatch({
    type: "ADD_COLOR",
    id: "6",
    title: "Party Pink",
    color: "#F142FF",
    timestamp: "Thu Mar 10 2016 01:11:12 GMT-0800 (PST)"
});