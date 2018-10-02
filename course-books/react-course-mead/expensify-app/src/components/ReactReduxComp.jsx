import React, {
    Component
} from 'react'

export default class ReactReduxComp extends Component {

    constructor(props) {
        super(props)
        this.state = {

            colors: [{
                "id": "8658c1d0-9eda-4a90-95e1-8001e8eb6036",
                "title": "Ocean Blue",
                "color": "#0070ff",
                "rating": 3
            }, {
                "id": "f9005b4e-975e-433d-a646-79df172e1dbb",
                "title": "Tomato",
                "color": "#d10012",
                "rating": 2
            }, {
                "id": "58d9caee-6ea6-4d7b-9984-65b145031979",
                "title": "Lawn",
                "color": "#67bf4f",
                "rating": 1
            }, {
                "id": "a5685c39-6bdc-4727-9188-6c9a00bf7f95",
                "title": "Party Pink",
                "color": "#ff00f7",
                "rating": 5
            }]
        }
    }
    addColor = (title, color) => {
        
    }

    rateColor = (id, rating) => {

    }

    removeColor = (id) => {

    }

    render() {


        return ( 
            <div>

            
            </div>
        )
    }
}