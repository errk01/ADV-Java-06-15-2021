import React from 'react'


const CheckItemList =(props)=>{

    console.log("props",props.firstItem)
    return(
        <div>
            My CheckList:
            {props.firstItem}
        </div>
    )
}

export default CheckItemList