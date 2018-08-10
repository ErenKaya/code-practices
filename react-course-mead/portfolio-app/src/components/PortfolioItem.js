import React from 'react';


const PortfolioItem = (props) => {
    return (
        <div>
            Portfolio individual number {props.match.params.id}
        </div>
    )
};

export default PortfolioItem; 