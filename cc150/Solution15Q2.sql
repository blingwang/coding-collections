select BuildingName isnull(Count, 0) as 'Count'
from Buildings
left join
    (
    select Apartments.BuildingID, count(*) as 'Count'
    from Apartments inner join Requests
    on Apartments.AptID = Requests.AptID
    where Requests.Status = 'Open'
    group by Apartments.BuildingID

    ) ReqCounts
on Buildings.BuildingID = ReqCounts.BuildingID;
