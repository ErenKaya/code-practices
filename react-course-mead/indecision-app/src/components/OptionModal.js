import React from 'react';
import Modal from 'react-modal';

const OptionModal = (props) => {

    return (
        <Modal
            isOpen={!!props.selectedOption}
            onRequestClose={props.handleModalOkay}
            contentLabel="Selected Option">
            <h3>Selected Option</h3>
            {props.selectedOption && <p>{props.selectedOption}</p>}
            <button onClick={props.handleModalOkay}>Okay</button>
        </Modal>
    )
};
export default OptionModal;