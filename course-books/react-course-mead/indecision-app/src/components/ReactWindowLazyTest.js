import React, { Fragment } from "react";
import Cell from "./LazyCell";
import { FixedSizeGrid as Grid } from "react-window";

export default class ReactWindowLazyTest extends React.Component {
  constructor() {
    super();
  }

  render() {
    return (
      <Fragment>
        <Grid
          className="Grid"
          columnCount={1000}
          columnWidth={100}
          height={150}
          ref={grid => (this.table = grid)}
          rowCount={1000}
          rowHeight={35}
          width={300}
        >
          {Cell}
        </Grid>
      </Fragment>
    );
  }
}
