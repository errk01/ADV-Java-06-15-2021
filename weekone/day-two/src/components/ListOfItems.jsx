import React from "react";

const ListOfItems = () => {
  let dataArr = [
    {
      id: 1,
      name: "John Snow",
      location: "Winterfalls",
    },
    {
      id: 2,
      name: "John Doe",
      location: "Little rock",
    },
  ];
  let listArr = dataArr.map((data) => {
    return (
      <div key={data.id}>
        <div>{data.name}</div>
        <div>{data.location}</div>
      </div>
    );
  });
  return <div>{listArr}</div>;
};

export default ListOfItems;
